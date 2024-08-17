package devandroid.marcell.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.marcell.applistacurso.model.Curso2;

public class CursoController {

    private List listCursos;

    public List getListadeCursos() {

        listCursos = new ArrayList<Curso2>();
        listCursos.add(new Curso2("Java"));
        listCursos.add(new Curso2("HTML"));
        listCursos.add(new Curso2("C#"));
        listCursos.add(new Curso2("Python"));
        listCursos.add(new Curso2("PHP"));
        listCursos.add(new Curso2("Flutter"));

        return listCursos;
    }

    public ArrayList<String> dadospParaSpinner() {

        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListadeCursos().size() ; i++) {
            Curso2 objeto = (Curso2) getListadeCursos().get(i);
            dados.add(objeto.getNomeDoCursoDesejado());
        }
        return dados;
    }

}
