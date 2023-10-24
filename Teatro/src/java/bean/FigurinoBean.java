/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import bd.BdFigurino;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;
import vo.Figurino;

/**
 *
 * @author 3Info2023
 */
@ManagedBean
@SessionScoped
public class FigurinoBean {
    
    private BdFigurino bdf = new BdFigurino();
    private Figurino figurino = new Figurino();
    private DataModel<Figurino> listaFigurino;
    private Boolean novo;
    private InputStream is;
    private StreamedContent imagem;
    private UploadedFile file;
    private String JPG = "image/jpeg";
    private String PNG = "image/png";
    
    public FigurinoBean(){
        
    }
    
    public String Cadastro(){
        return "cadastroFigurino";
    }

    public String salvar(){
            if (getFigurino() == null) {
                getBdf().inserir(getFigurino());
                atualizaLista();
                return "figurinos";
            } else {
                try {
                    byte [] bytes = readAllBytes(is);
                    figurino.setFoto(bytes);
                    getBdf().salvar(figurino);
                } catch (Exception e) {
                    FacesMessage message = new FacesMessage("Erro", e.getLocalizedMessage());
                    PrimeFaces.current().dialog().showMessageDynamic(message);
                }
                atualizaLista();
                return "figurinos";
            }
    }
    
    public void handleFileUpload(FileUploadEvent event){
        setFile(event.getFile());
        setImagem(new DefaultStreamedContent());
        String tipo = getFile().getContentType();
        if (!tipo.equals(JPG) && !tipo.equals(PNG)) {
            FacesMessage message = new FacesMessage("Atenção", "Este não é um arquivo de imagem válida");
            PrimeFaces.current().dialog().showMessageDynamic(message);
        } else {
            try {
                setIs(getFile().getInputStream());
                setImagem(DefaultStreamedContent.builder()
                        .contentType(tipo).stream(() -> new ByteArrayInputStream(getFile().getContent())).build());
            } catch (Exception e) {
                FacesMessage message = new FacesMessage("Erro", e.getLocalizedMessage());
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }
        }
    }
    
    
    
    public static byte[] readAllBytes(InputStream inputStream) throws IOException {
        final int bufLen = 4 * 0x400;
        byte[] buf = new byte[bufLen];
        int readLen;
        IOException exception = null;
        
        try {
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                while ((readLen = inputStream.read(buf, 0, bufLen)) != -1) {
                    outputStream.write(buf, 0, readLen);
                }
                return outputStream.toByteArray();
            }
        } catch (IOException e) {
            exception = e;
            throw e;
        } finally {
            if(exception == null) {
                inputStream.close();
            } else try{
                    inputStream.close();
                } catch (IOException e) {
                    exception.addSuppressed(e);
                }
            }
        }
    
    public final void atualizaLista(){
        setListaFigurino((DataModel<Figurino>) new ListDataModel(getBdf().pesquisar()));
    }
    /**
     * @return the bdf
     */
    public BdFigurino getBdf() {
        return bdf;
    }

    /**
     * @param bdf the bdf to set
     */
    public void setBdf(BdFigurino bdf) {
        this.bdf = bdf;
    }

    /**
     * @return the figurino
     */
    public Figurino getFigurino() {
        return figurino;
    }

    /**
     * @param figurino the figurino to set
     */
    public void setFigurino(Figurino figurino) {
        this.figurino = figurino;
    }

    /**
     * @return the listaFigurino
     */
    public DataModel<Figurino> getListaFigurino() {
        return listaFigurino;
    }

    /**
     * @param listaFigurino the listaFigurino to set
     */
    public void setListaFigurino(DataModel<Figurino> listaFigurino) {
        this.listaFigurino = listaFigurino;
    }

    /**
     * @return the novo
     */
    public Boolean getNovo() {
        return novo;
    }

    /**
     * @param novo the novo to set
     */
    public void setNovo(Boolean novo) {
        this.novo = novo;
    }

    /**
     * @return the is
     */
    public InputStream getIs() {
        return is;
    }

    /**
     * @param is the is to set
     */
    public void setIs(InputStream is) {
        this.is = is;
    }

    /**
     * @return the imagem
     */
    public StreamedContent getImagem() {
        return imagem;
    }

    /**
     * @param imagem the imagem to set
     */
    public void setImagem(StreamedContent imagem) {
        this.imagem = imagem;
    }

    /**
     * @return the file
     */
    public UploadedFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(UploadedFile file) {
        this.file = file;
    }

    /**
     * @return the JPG
     */
    public String getJPG() {
        return JPG;
    }

    /**
     * @param JPG the JPG to set
     */
    public void setJPG(String JPG) {
        this.JPG = JPG;
    }

    /**
     * @return the PNG
     */
    public String getPNG() {
        return PNG;
    }

    /**
     * @param PNG the PNG to set
     */
    public void setPNG(String PNG) {
        this.PNG = PNG;
    }
    
    
    
}
