package com.example.definitivo.servicesImpl;

import com.example.definitivo.entities.Coche;
import com.example.definitivo.repositories.CocheRespository;
import com.example.definitivo.services.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CocheServiceImpl implements CocheService {

    @Autowired
    CocheRespository cocheRepository;

    @Override
    public List<Coche> findAllCoches() {
        return cocheRepository.findAll();
    }

    @Override
    public Optional<Coche> findCocheById(Integer id) {
        return cocheRepository.findById(id);
    }

    @Override
    public List<Coche> findCocheByIdConcesionario(Integer id, String orderBy) {
        //El orderBy es segun quiera el usuario order de una manera u otra
        if(orderBy.equals("fechaVenta")){
            return cocheRepository.findByIdConcesionarioOrderByFechaVenta(id);
        }
        else if(orderBy.equals("fechaIngreso")){
            return cocheRepository.findByIdConcesionarioOrderByFechaIngreso(id);
        }
        return cocheRepository.findByIdConcesionario(id);
    }

    @Override
    public String saveCoche(Coche cocheNew) {
        //La comprobacion del Id es porque se auto genera el id en la bbdd
        if (cocheNew != null && cocheNew.getId() == null) {
            cocheRepository.save(cocheNew);
            return "El coche: " + cocheNew.getId() + " ha sido añadido";
        }
        return null;
    }

    @Override
    public String deleteCoche(Integer id) {
        //cocheDB -> reocegemos el objeto coche a traves de su id
        Optional<Coche> cocheDB = cocheRepository.findById(id);
        if (cocheDB.isPresent()) {
            //Si existe lo mapeamos
            Coche cocheToDelete = cocheDB.get();
            if(!cocheToDelete.getVendido()){
                //Si no esta vendido lo eliminamos
                cocheRepository.deleteById(id);
                return "Coche: " + id + " eliminado correctamente.";
            }
        }
        return "Error! El coche: " + id +  " no ha sido eliminado";
    }

    public String matricularCoche(Integer id, String matricula){
        Optional<Coche> cocheDB = cocheRepository.findById(id);
        if (cocheDB.isPresent()) {
            Coche cocheToUpdate = cocheDB.get();
            if(!cocheToUpdate.getVendido()){
                cocheToUpdate.setMatricula(matricula);
                cocheRepository.save(cocheToUpdate);

                return "Se ha matriculado el coche: " + id;
            }
        }
        return "NO se ha matricular el coche: " + id;
    }

    public String venderCoche(Integer id, Float precioVenta){
        Optional<Coche> cocheDB = cocheRepository.findById(id);
        if (cocheDB.isPresent()) {
            Coche cocheToUpdate = cocheDB.get();
            if(!cocheToUpdate.getVendido() && !cocheToUpdate.getMatricula().isEmpty()){
                //Entiendo que para un coche poder ser vendido tiene que estar matriculado
                cocheToUpdate.setPrecioVenta(precioVenta);
                cocheToUpdate.setFechaVenta(new Date());
                cocheToUpdate.setVendido(true);
                cocheRepository.save(cocheToUpdate);

                return "Se ha vendido el coche: " + id;
            }
        }
        return "NO se ha vendido el coche: " + id;
    }

    public Float beneficios(Integer idConcesionario){
        //La peticion de beneficios sera global o de un concesionario en funcion del parametro
        if(idConcesionario == null){
            //SELECT IFNULL(SUM(precio_venta)-SUM(coste),0) as beneficio FROM coches;
            return cocheRepository.beneficiosCadena();
        }
        else{
            //SELECT IFNULL(SUM(precio_venta)-SUM(coste),0) as beneficio FROM coches WHERE id_concesionario = 1;
            return cocheRepository.beneficiosConcesionario(idConcesionario);
        }
    }
}
