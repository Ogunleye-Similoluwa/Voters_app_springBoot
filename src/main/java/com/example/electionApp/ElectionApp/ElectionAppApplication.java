package com.example.electionApp.ElectionApp;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@Slf4j
public class ElectionAppApplication {


//	@Bean
//	StandardPBEStringEncryptor encryptor (){
//		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
//		encryptor.setAlgorithm("PBEWithHmacSHA512AndAES_256");
////		encryptor.setPassword(encryptionPassword);
//		return encryptor;
//	}

	public static void main(String[] args) {
		SpringApplication.run(ElectionAppApplication.class, args);



		String password =  "Simex";
//		String encodedPassword = encoder.encode(password);
//
//		log.info("password: " + password);
//		log.info("Encoded password: " + encodedPassword);
//
//
//		boolean matches = encoder.matches(password, encodedPassword);
//		log.info("matches: " + matches);
//		@Bean
//	StandardPBEStringEncryptor encryptor (){
//		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
//		encryptor.setAlgorithm("PBEWithHmacSHA512AndAES_256");
//		return encryptor;
//	}

		String encryptionPassword = "qwaszxerdfcvmnlkpo";
		BasicTextEncryptor encryptor = new BasicTextEncryptor();
		encryptor.setPassword(encryptionPassword);

		String encryptedPassword =encryptor.encrypt(password);
		log.info("Encrypted password: " + encryptedPassword);

		String decryptedPassword =encryptor.decrypt(encryptedPassword);
		log.info("Decrypted password: " + decryptedPassword);


	}

}
