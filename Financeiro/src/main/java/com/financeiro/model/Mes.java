package com.financeiro.model;

public enum Mes {
    
    MES01_2016("01/2016"),
    MES02_2016("02/2016"),
    MES03_2016("03/2016"),
    MES04_2016("04/2016"),
    MES05_2016("05/2016"),
    MES06_2016("06/2016"),
    MES07_2016("07/2016"),
    MES08_2016("08/2016"),
    MES09_2016("09/2016"),
    MES010_2016("10/2016"),
    MES011_2016("11/2016"),
    MES012_2016("12/2016");
    
    private String descricao;

    Mes(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    
}
