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
        if(orderBy.equals("fechaVenta")){
            return cocheRepository.findByIdConcesionarioOrderByFechaVenta(id);
        }
        else if(orderBy.equals("fechaIngreso")){
            return cocheRepository.findByIdConcesionarioOrderByFechaIngreso(id);
        }
        return cocheRepository.findByIdConcesionario(id);
    }

    @Override
    public Coche saveCoche(Coche cocheNew) {
        if (cocheNew != null) {
            return cocheRepository.save(cocheNew);
        }
        return new Coche();
    }

    @Override
    public String deleteCoche(Integer id) {
        Optional<Coche> cocheDB = cocheRepository.findById(id);
        if (cocheDB.isPresent()) {
            Coche cocheToDelete = cocheDB.get();
            if(!cocheToDelete.getVendido()){
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
                cocheToUpdate.setPrecioVenta(precioVenta);
                cocheToUpdate.setFechaVenta(new Date());
                cocheToUpdate.setVendido(true);
                cocheRepository.save(cocheToUpdate);

                return "Se ha vendido el coche: " + id;
            }
        }
        return "NO se ha vendido el coche: " + id;
    }
}
