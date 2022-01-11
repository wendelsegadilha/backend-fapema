package wyz.wendelsegadilha.fapema.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "arquivo")
public class ArmazenamentoArquivoConfig {
	
	
	private String uploadDir;
	
	public String getUploadDir() {
		return uploadDir;
	}
	
	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
}
