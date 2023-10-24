/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author 3Info2023
 */
@ManagedBean
@SessionScoped
public class InicioBean {
    private String login;
    private String senha;
    public InicioBean(){
        }
    
    public String entrar(){
        if(login.equals("admin") && senha.equals("teatro")) {
            return "inicio";
        } else {
            FacesMessage fm = new FacesMessage("Erro", "Senha ou Login incorreto.");
            PrimeFaces.current().dialog().showMessageDynamic(fm);
        }
        return null;
    }
    
    public String figurinos(){
        return "figurinos";
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
