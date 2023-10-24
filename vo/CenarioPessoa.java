/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vo;

import java.util.Date;

/**
 *
 * @author 3info2023
 */
public class CenarioPessoa {
    private int idcenario;
    private int idpessoa;
    private Date dataemprestimo;
    private boolean devolvido;

    /**
     * @return the idcenario
     */
    public int getIdcenario() {
        return idcenario;
    }

    /**
     * @param idcenario the idcenario to set
     */
    public void setIdcenario(int idcenario) {
        this.idcenario = idcenario;
    }

    /**
     * @return the idpessoa
     */
    public int getIdpessoa() {
        return idpessoa;
    }

    /**
     * @param idpessoa the idpessoa to set
     */
    public void setIdpessoa(int idpessoa) {
        this.idpessoa = idpessoa;
    }

    /**
     * @return the dataemprestimo
     */
    public Date getDataemprestimo() {
        return dataemprestimo;
    }

    /**
     * @param dataemprestimo the dataemprestimo to set
     */
    public void setDataemprestimo(Date dataemprestimo) {
        this.dataemprestimo = dataemprestimo;
    }

    /**
     * @return the devolvido
     */
    public boolean isDevolvido() {
        return devolvido;
    }

    /**
     * @param devolvido the devolvido to set
     */
    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }
}
