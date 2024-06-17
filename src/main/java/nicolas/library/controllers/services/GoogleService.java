package nicolas.library.controllers.services;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class GoogleService {
    /**
     * name of the firebase project - set this prop in application.properties
     */
    @Value("${firebase.bucket.images}")
    private String imageBucket;

    /**
     * credentials for the firebase project = content of the private-key-json file generated in firebase.
     * ATTENTION: do not store this value in git!!!!!
     */
    @Value("${firebase.credentials}")
    private String firebaseCredentials;

    public String toFirebase(InputStream inputStream, String folderName, String fileName) throws IOException {
        String fullObjectName = folderName + "/" + fileName;
        BlobId blobId = BlobId.of(imageBucket, fullObjectName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        Storage storage = getFirebaseStorage();
        storage.createFrom(blobInfo, inputStream);
        inputStream.close();
        String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/%s/o/%s?alt=media";
        return String.format(DOWNLOAD_URL, imageBucket, URLEncoder.encode(fullObjectName, StandardCharsets.UTF_8));
    }

    private Storage getFirebaseStorage() throws IOException {
        Credentials credentials = GoogleCredentials.fromStream(new ByteArrayInputStream(firebaseCredentials.getBytes()));
        return StorageOptions.newBuilder().setCredentials(credentials).build().getService();
    }
}
