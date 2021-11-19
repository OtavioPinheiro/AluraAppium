package com.alura.appium;

import static org.junit.Assert.assertTrue;

import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class FeatureCadastro
{
    @Test
    public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem() throws MalformedURLException {
        AppiumDriverConfig driver = new AppiumDriverConfig();

        String prefixo = "br.com.alura.aluraesporte:id/";
        MobileElement botaoCadastro = (MobileElement)driver.driver.findElementById(prefixo+"login_botao_cadastrar_usuario");
        botaoCadastro.click();

        MobileElement campoNome = (MobileElement)driver.driver.findElementById(prefixo+"input_nome");
        MobileElement campoSenha = (MobileElement)driver.driver.findElementById(prefixo+"input_senha");
        MobileElement campoConfirmarSenha = (MobileElement)driver.driver.findElementById(prefixo+"input_confirmar_senha");
        MobileElement botaoConfirmarCadastro = (MobileElement)driver.driver.findElementById(prefixo+"cadastro_usuario_botao_cadastrar");

        campoNome.setValue("Otavio");
        campoSenha.setValue("123");
        campoConfirmarSenha.setValue("456");
//das
        botaoConfirmarCadastro.click();
        MobileElement msgErro = (MobileElement)driver.driver.findElementById(prefixo+"erro_cadastro");

        Assert.assertEquals("Senhas não conferem", msgErro.getText());
    }
}
