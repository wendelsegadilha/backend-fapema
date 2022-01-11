package wyz.wendelsegadilha.fapema.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import wyz.wendelsegadilha.fapema.config.ArmazenamentoArquivoConfig;
import wyz.wendelsegadilha.fapema.services.exceptions.ArmazenamentoArquivoException;
import wyz.wendelsegadilha.fapema.services.exceptions.ArquivoNotFoundException;

@Service
public class ArmazenamentoArquivoService {

	private final Path caminhoArmazenamentoArquivo;

	@Autowired
	public ArmazenamentoArquivoService(ArmazenamentoArquivoConfig armazenamentoArquivoConfig) {

		this.caminhoArmazenamentoArquivo = Paths.get(armazenamentoArquivoConfig.getUploadDir()).toAbsolutePath()
				.normalize();

		try {
			Files.createDirectories(this.caminhoArmazenamentoArquivo);
		} catch (Exception e) {
			throw new ArmazenamentoArquivoException(
					"Não foi possível criar o diretório para o armazenamento do arquivo");
		}
	}

	public String salvarArquivo(MultipartFile arquivo) {
		String nomeArquivo = StringUtils.cleanPath(arquivo.getOriginalFilename());
		try {
			if (nomeArquivo.contains("..")) {
				throw new ArmazenamentoArquivoException(
						"Desculpe! O nome do arquivo contém uma sequência de caracteres inválida: " + nomeArquivo);
			}

			Path caminhoDestino = this.caminhoArmazenamentoArquivo.resolve(nomeArquivo);
			Files.copy(arquivo.getInputStream(), caminhoDestino, StandardCopyOption.REPLACE_EXISTING);

			return nomeArquivo;
		} catch (Exception e) {
			throw new ArmazenamentoArquivoException("Não foi possível armazenar o arquivo: " + nomeArquivo);
		}
	}

	public Resource carregarArquivoComoRecurso(String nomeArquivo) {
		try {
			Path caminhoDestino = this.caminhoArmazenamentoArquivo.resolve(nomeArquivo).normalize();
			Resource recurso = new UrlResource(caminhoDestino.toUri());
			if (recurso.exists()) {
				return recurso;
			} else {
				throw new ArquivoNotFoundException("Arquivo não encontrado: " + nomeArquivo);
			}
		} catch (Exception e) {
			throw new ArquivoNotFoundException("Arquivo não encontrado: " + nomeArquivo);
		}
	}

}
