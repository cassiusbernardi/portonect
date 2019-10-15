package com.prumo.portonect.util;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

import br.com.caelum.vraptor.observer.upload.UploadedFile;

public class ArquivoUtil {

    public static String geraNomeArquivo(String nomeArquivo,UploadedFile arquivo) throws Exception {
        if (arquivo != null) {

//            nomeArquivo = FilenameUtils.removeExtension(arquivo.getFileName());
            nomeArquivo += "." + FilenameUtils.getExtension(arquivo.getFileName());

            return PropertiesUtil.getPasta() + "\\" + nomeArquivo;

        } else {
//            return "E:\\visitaweb\\imagens\\LGN_ID-0-VST_ID-0-DOC-0.jpg";
            return "C:\\Users\\120000499\\Documents\\sbs\\teste.jpg";
        }

    }

    public static void salvarArquivo(String nomeArquivo, UploadedFile arquivo) throws Exception {
        File imagemDocumento = new File(nomeArquivo);
        arquivo.writeTo(imagemDocumento);
    }

    public static void excluirArquivo(String pathArquivo) throws Exception {
        File file = new File(pathArquivo);
        file.delete();
    }

}
