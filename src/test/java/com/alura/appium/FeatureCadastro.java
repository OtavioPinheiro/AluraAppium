package com.alura.appium;

import static org.junit.Assert.assertTrue;

import com.alura.appium.PageObjects.CadastroPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import java.net.MalformedURLException;

public class FeatureCadastro {
    private String prefixo = "br.com.alura.aluraesporte:id/";

    @Test
    public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        MobileElement botaoCadastro = (MobileElement)driver.findElementById(prefixo+"login_botao_cadastrar_usuario");
        botaoCadastro.click();

        CadastroPageObject telaCadastro = new CadastroPageObject(driver);
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar("Otávio", "123", "456");

        Assert.assertEquals("Senhas não conferem", telaCadastro.MensagemErro());
        driver.navigate().back();
    }

    @Test
    public void posso_cadastrar_usuario_com_senhas_que_conferem() throws NoSuchElementException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        MobileElement botaoCadastro = (MobileElement)driver.findElementById(prefixo+"login_botao_cadastrar_usuario");
        botaoCadastro.click();

        CadastroPageObject telaCadastro = new CadastroPageObject(driver);
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar("Otávio", "123", "123");
        MobileElement botaoLogar = (MobileElement) driver.findElementById(prefixo+"login_botao_logar");
    }
}
