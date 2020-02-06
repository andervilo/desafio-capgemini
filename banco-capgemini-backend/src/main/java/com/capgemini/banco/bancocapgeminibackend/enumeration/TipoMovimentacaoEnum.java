package com.capgemini.banco.bancocapgeminibackend.enumeration;

public enum TipoMovimentacaoEnum {
    SAQUE(1, "Saque"),
    DEPOSITO(2, "Depósito");
    
    private final Integer codigo;
    private final String descricao;

    private TipoMovimentacaoEnum(final Integer codigo, final String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return this.codigo;
    } 

    public String getDescricao() {
        return this.descricao;
    }

    public TipoMovimentacaoEnum getByCodigo(Integer codigo){
        if(codigo != null && codigo > 0){
            switch (codigo) {
                case 1:
                    return TipoMovimentacaoEnum.SAQUE;
                case 2:
                    return TipoMovimentacaoEnum.DEPOSITO; 
                default:
                    return null;
            }
        }
        return null;
    }
}