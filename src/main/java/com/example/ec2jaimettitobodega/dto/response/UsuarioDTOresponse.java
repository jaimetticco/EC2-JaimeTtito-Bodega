package com.example.ec2jaimettitobodega.dto.response;

public class UsuarioDTOresponse {

    private Integer id_usu;
    private String usuario_bod;
    private String password_usu;
    private String rol_usu;
    private String token;



    public UsuarioDTOresponse(String token) {
        super();
        this.token = token;
    }

    public UsuarioDTOresponse() {
        super();
        // TODO Auto-generated constructor stub
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId_usu() {
        return id_usu;
    }

    public void setId_usu(Integer id_usu) {
        this.id_usu = id_usu;
    }

    public String getUsuario_bod() {
        return usuario_bod;
    }

    public void setUsuario_bod(String usuario_bod) {
        this.usuario_bod = usuario_bod;
    }

    public String getPassword_usu() {
        return password_usu;
    }

    public void setPassword_usu(String password_usu) {
        this.password_usu = password_usu;
    }

    public String getRol_usu() {
        return rol_usu;
    }

    public void setRol_usu(String rol_usu) {
        this.rol_usu = rol_usu;
    }


}
