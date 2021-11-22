package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public LoginPageObject Cadastrar(String usuario, String senha, String confirmacao) {
        PreencherFormulario(usuario, senha, confirmacao);
        botaoCadastrar.click();
        return new LoginPageObject(this.driver);
    }

    public String MensagemErro(){
        By erroSenha = By.id(prefixo+"erro_cadastro");
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(erroSenha));

        msgErro = (MobileElement)driver.findElementById(prefixo+"erro_cadastro");
        return msgErro.getText();
    }
}
