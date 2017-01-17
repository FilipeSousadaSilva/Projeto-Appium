/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.candowell.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author filip
 */
public class TesteExemplo {
    
    public TesteExemplo() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void test() throws MalformedURLException {
		
		//Diretorio onde contem a apk do aplicativo que sera automatizado
		File diretorioAplicacao = new File("C:\\App");
		//Nome do aplicativo que deve ser
		File arquivoAplicacao = new File(diretorioAplicacao, "CalculaMediaFinal.apk");
		
		DesiredCapabilities capacidade = new DesiredCapabilities();
		//Define que a plataforma que o teste sera executado e Android
		capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		//Define que o aplicativo sera executado pelo emulador do Android
                capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		//capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
		//Define qual o caminho onde esta o apk do aplicativo que sera automatizado
		capacidade.setCapability(MobileCapabilityType.APP, arquivoAplicacao.getAbsolutePath());
                

		@SuppressWarnings("rawtypes")
		//Instancia o driver do Android apontando para o ip do servidor Appium e passando as configuracoes defindas acima
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Informa as notas do campo 1, 2 e 3
		driver.findElement(By.id("com.exemplo.calculamediafinal:id/txtNota1")).sendKeys("3");
		driver.findElement(By.id("com.exemplo.calculamediafinal:id/txtNota2")).sendKeys("2");
		driver.findElement(By.id("com.exemplo.calculamediafinal:id/txtNota3")).sendKeys("4");
		//Clica no botao Calcular
		driver.findElement(By.id("com.exemplo.calculamediafinal:id/btnCalcular")).click();
		//Compara o valor gerado no cmapo media final com o valor esperado pelo teste
		Assert.assertEquals("3.0", driver.findElement(By.id("com.exemplo.calculamediafinal:id/txtMediaFinal")).getText());
			
	}
    
}
