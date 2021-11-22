package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPageObject {
    private String prefixo = "br.com.alura.aluraesporte:id/";
    private MobileElement botaoCadastro;
    private AppiumDriver driver;

    public LoginPageObject(AppiumDriver driver) {
        this.driver = driver;
    }

    public void BuscarElementos() {
        botaoCadastro = (MobileElement)driver.findElementById(prefixo+"login_botao_cadastrar_usuario");
    }

    public CadastroPageObject IrParaTelaDeCadastro() {
        botaoCadastro.click();
        return new CadastroPageObject(this.driver);
    }
}
