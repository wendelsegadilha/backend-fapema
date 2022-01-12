package wyz.wendelsegadilha.fapema.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import wyz.wendelsegadilha.fapema.domain.Aluno;
import wyz.wendelsegadilha.fapema.services.AlunoService;
import wyz.wendelsegadilha.fapema.services.ArmazenamentoArquivoService;

@RestController
@RequestMapping("/uploadImagem")
public class UploadImageController {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadImageController.class);
	
	private final ArmazenamentoArquivoService armazenamentoArquivoService;
	private final AlunoService alunoService;

	public UploadImageController(ArmazenamentoArquivoService armazenamentoArquivoService, AlunoService alunoService) {
		super();
		this.armazenamentoArquivoService = armazenamentoArquivoService;
		this.alunoService = alunoService;
	}

	@PostMapping("/{id}")
	public ResponseEntity<Aluno> uploadArquivo(@PathVariable("id") Integer id,
			@RequestParam("arquivo") MultipartFile arquivo) {

		Aluno aluno = alunoService.buscarPorId(id);
		String nomeArquivo = "";
		String UridownloadArquivo = "";

		if (aluno != null) {
			nomeArquivo = armazenamentoArquivoService.salvarArquivo(arquivo);

			UridownloadArquivo = ServletUriComponentsBuilder.fromCurrentContextPath().path("/arquivos/downloadImagem/")
					.path(nomeArquivo).toUriString();
			aluno.setImagem(UridownloadArquivo);
			alunoService.atualizar(aluno);
		}
		return ResponseEntity.ok().body(aluno);
	}
	
	@GetMapping("/downloadImagem/{nomeArquivo:.+}")
	public ResponseEntity<Resource> downloadArquivo(@PathVariable String nomeArquivo, HttpServletRequest request) {
		
		Resource recurso = armazenamentoArquivoService.carregarArquivoComoRecurso(nomeArquivo);
		
		String contentType = null;
		
		try {
			contentType = request.getServletContext().getMimeType(recurso.getFile().getAbsolutePath());
		} catch (Exception e) {
			logger.info("Não foi possível determinar o tipo de arquivo");
		}
		
		if (contentType == null) {
			contentType = "application/octet-stream";
		}
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename()+ "\"")
				.body(recurso);
	}

}
