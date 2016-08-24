package net.almaak.cms.migration.dao.entities.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.almaak.cms.migration.dao.entities.Image;
import net.almaak.cms.migration.dao.entities.ImageReference;
import org.springframework.jdbc.core.RowMapper;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ImageReferenceMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        ImageReference imageReference = new ImageReference();
        try {
            imageReference.setImages(convertImagesJSONToList(rs.getString("images"), imageReference));
        } catch (IOException ioe) {
            throw new SQLException(ioe);
        }
        return imageReference;
    }

    private List<Image> convertImagesJSONToList(String imagesJSON, ImageReference imgReference) throws IOException{
        List<Image> imageList = mapImageVOToImage(new ObjectMapper().readValue(imagesJSON, ImageVO.class), imgReference);
        return imageList;
    }

    private List<Image> mapImageVOToImage(ImageVO imageVO, ImageReference imgReference) {
        List<Image> imgList = new ArrayList<Image>();
        Image img = new Image();
        img.addImageReference(imgReference);
        // TODO the role here is intro picture, text picture etc.
        img.setImageRole("");
        img.setImageData(new byte[1024]);
        imgList.add(img);
        return imgList;

    }
}
