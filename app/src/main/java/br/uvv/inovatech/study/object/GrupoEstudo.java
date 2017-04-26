package br.uvv.inovatech.study.object;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class GrupoEstudo implements Serializable {
    public Long id;
    public String nome;
    public Disciplina disciplina;
    public List<Usuario> membros;
    public Date quando;
    public String local;
    public String descricao;
}
