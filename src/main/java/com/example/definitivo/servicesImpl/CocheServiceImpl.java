package com.example.definitivo.servicesImpl;

import com.example.definitivo.entities.Coche;
import com.example.definitivo.repositories.CocheRespository;
import com.example.definitivo.services.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        if (cocheRepository.findById(id).isPresent()) {
            cocheRepository.deleteById(id);
            return "Coche: " + id + " eliminado correctamente.";
        }
        return "Error! El coche: " + id +  " no existe";
    }

    @Override
    public String updateCoche(Coche cocheUpdated) {
        Integer num = cocheUpdated.getId();
        if (cocheRepository.findById(num).isPresent()) {
            Coche cocheToUpdate = new Coche();
            cocheToUpdate.setId(cocheUpdated.getId());
            cocheToUpdate.setMarca(cocheUpdated.getMarca());
            cocheToUpdate.setCoste(cocheUpdated.getCoste());
            cocheToUpdate.setFechaIngreso(cocheUpdated.getFechaIngreso());
            cocheToUpdate.setFechaVenta(cocheUpdated.getFechaVenta());
            cocheToUpdate.setVendido(cocheUpdated.getVendido());
            cocheToUpdate.setMatricula(cocheUpdated.getMatricula());
            cocheToUpdate.setPrecioVenta(cocheUpdated.getPrecioVenta());
            cocheToUpdate.setIdConcesionario(cocheToUpdate.getIdConcesionario());
            cocheRepository.save(cocheToUpdate);

            return "Coche: " + cocheUpdated.getId() + " modificado";
        }
        return "Error al modificar el coche:" + cocheUpdated.getId();
    }
}
