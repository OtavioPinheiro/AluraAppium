package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPageObject extends PageObjectBase{
    private MobileElement campoNome;
    private MobileElement campoSenha;
    private MobileElement campoConfirmarSenha;
    private MobileElement botaoCadastrar;
    private String prefixo = "br.com.alura.aluraesporte:id/";
    private MobileElement msgErro;
    private final By erroID;
    private final By campoNomeID;
    private final By campoSenhaID;
    private final By campoConfirmarID;
    private final By botaoCadastrarID;

    public CadastroPageObject(AppiumDriver driver){
        super(driver);
        erroID = By.id(prefixo + "erro_cadastro");
        campoNomeID = By.id(prefixo + "input_nome");
        campoSenhaID = By.id(prefixo + "input_senha");
        campoConfirmarID = By.id(prefixo + "input_confirmar_senha");
        botaoCadastrarID = By.id(prefixo + "cadastro_usuario_botao_cadastrar");
    }

    @Override
    public void BuscarElementos() {
        campoNome = (MobileElement) driver.findElement(campoNomeID);
        campoSenha = (MobileElement) driver.findElement(campoSenhaID);
        campoConfirmarSenha = (MobileElement)driver.findElement(campoConfirmarID);
        botaoCadastrar = (MobileElement) driver.findElement(botaoCadastrarID);
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
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(erroID));

        msgErro = (MobileElement)driver.findElementById(prefixo+"erro_cadastro");
        return msgErro.getText();
    }
}
