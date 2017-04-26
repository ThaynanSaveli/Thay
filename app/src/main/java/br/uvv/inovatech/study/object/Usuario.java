package br.uvv.inovatech.study.object;

import java.io.Serializable;

public class Usuario implements Serializable {
    public Long id;
    public String token;
    public String nome;
    public String matricula;
    public String senha;
}
