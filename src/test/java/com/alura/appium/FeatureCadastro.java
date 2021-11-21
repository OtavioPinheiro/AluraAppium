package com.alura.appium;

import static org.junit.Assert.assertTrue;

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

        MobileElement campoNome = (MobileElement)driver.findElementById(prefixo+"input_nome");
        MobileElement campoSenha = (MobileElement)driver.findElementById(prefixo+"input_senha");
        MobileElement campoConfirmarSenha = (MobileElement)driver.findElementById(prefixo+"input_confirmar_senha");
        MobileElement botaoConfirmarCadastro = (MobileElement)driver.findElementById(prefixo+"cadastro_usuario_botao_cadastrar");

        campoNome.setValue("Otavio");
        campoSenha.setValue("123");
        campoConfirmarSenha.setValue("456");

        botaoConfirmarCadastro.click();
        MobileElement msgErro = (MobileElement)driver.findElementById(prefixo+"erro_cadastro");

        Assert.assertEquals("Senhas não conferem", msgErro.getText());
    }

    @Test
    public void posso_cadastrar_usuario_com_senhas_que_conferem() throws NoSuchElementException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        MobileElement botaoCadastro = (MobileElement)driver.findElementById(prefixo+"login_botao_cadastrar_usuario");
        botaoCadastro.click();

        MobileElement campoNome = (MobileElement) driver.findElementById(prefixo+"input_nome");
        MobileElement campoSenha = (MobileElement) driver.findElementById(prefixo+"input_senha");
        MobileElement campoConfirmarSenha = (MobileElement)driver.findElementById(prefixo+"input_confirmar_senha");
        MobileElement botaoConfirmarCadastro = (MobileElement) driver.findElementById(prefixo+"cadastro_usuario_botao_cadastrar");

        campoNome.setValue("Otavio");
        campoSenha.setValue("123");
        campoConfirmarSenha.setValue("123");

        botaoConfirmarCadastro.click();
        MobileElement botaoLogar = (MobileElement) driver.findElementById(prefixo+"login_botao_logar");
    }
}
