package demo.example.democrud.dto;


import com.example.democrud.model.Actividad;

import java.util.List;

public class TareaContenidoDTO {

    private Long idTarea;
    private Iterable<Actividad> actividadesDTOList;

    public TareaContenidoDTO(){

    }

    public Long getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Long idTarea) {
        this.idTarea = idTarea;
    }

    public Iterable<Actividad> getActividades() {
        return actividadesDTOList;
    }

    public void setActividadesDTOList(List<Actividad> actividadesDTOList) {
        this.actividadesDTOList = actividadesDTOList;
    }
}
