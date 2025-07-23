package br.com.andreaza.image_upload.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ImageUploadService {

    private static final String UPLOAD_DIR = new File("uploads").getAbsolutePath();

    public String saveImage(MultipartFile img) throws IOException {
        // Verifica se está vazio
        if(img == null || img.isEmpty()) {
            return "Imagem está vazia";
        }

        File pastUpload = new File(UPLOAD_DIR);
        //Cria a pasta se não existir
        if(!pastUpload.exists()) {
            pastUpload.mkdirs();
        }

        //Define o caminho completo da nova foto
        String caminhoFinal = UPLOAD_DIR + File.separator + img.getOriginalFilename();
        File destino = new File(caminhoFinal);

        if(destino.exists()) {
            return "Já existe uma foto com esse nome";
        }

        //Salva o arquivo
        img.transferTo(destino);

        return "Imagem salva com sucess : " + img.getOriginalFilename();
    }

}
