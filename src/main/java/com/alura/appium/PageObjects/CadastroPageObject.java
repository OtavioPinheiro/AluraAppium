package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CadastroPageObject {
    private AppiumDriver driver;
    private MobileElement campoNome;
    private MobileElement campoSenha;
    private MobileElement campoConfirmarSenha;
    private MobileElement botaoCadastrar;
    private String prefixo = "br.com.alura.aluraesporte:id/";
    private MobileElement msgErro;

    public CadastroPageObject(AppiumDriver driver){
        this.driver = driver;
    }

    public void BuscarElementos() {
        campoNome = (MobileElement) driver.findElementById(prefixo+"input_nome");
        campoSenha = (MobileElement) driver.findElementById(prefixo+"input_senha");
        campoConfirmarSenha = (MobileElement)driver.findElementById(prefixo+"input_confirmar_senha");
        botaoCadastrar = (MobileElement) driver.findElementById(prefixo+"cadastro_usuario_botao_cadastrar");
    }

    private void PreencherFormulario(String usuario, String senha, String confirmacao) {
        campoNome.setValue(usuario);
        campoSenha.setValue(senha);
        campoConfirmarSenha.setValue(confirmacao);
    }

    public void Cadastrar(String usuario, String senha, String confirmacao) {
        PreencherFormulario(usuario, senha, confirmacao);
        botaoCadastrar.click();
    }

    public String MensagemErro(){
        msgErro = (MobileElement)driver.findElementById(prefixo+"erro_cadastro");
        return msgErro.getText();
    }
}
