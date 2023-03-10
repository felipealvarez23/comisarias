package co.com.efalvare.config;

import co.com.bancolombia.secretsmanager.config.AWSSecretsManagerConfig;
import co.com.bancolombia.secretsmanager.connector.AWSSecretManagerConnectorAsync;
import co.com.efalvare.model.secret.DBSecretModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;

@Configuration
public class PostgresDBConfig {

    @Value("${db.password:#{null}}")
    private String password;

    @Value("${db.dbname:#{null}}")
    private String dbname;

    @Value("${db.port:#{null}}")
    private Integer port;

    @Value("${db.host:#{null}}")
    private String host;

    @Value("${db.username:#{null}}")
    private String username;

    @Value("${spring.profiles.active}")
    private String perfil;

    @Bean
    public DBSecretModel getDBSecretManager(@Value("${db.secret.region:#{null}}") String region, @Value("${db.secret.name:#{null}}") String secretName ) {
        if (this.perfil.equals("dev-local") || this.perfil.equals("test"))
            return dbSecretModelLocal();
        else
            return new AWSSecretManagerConnectorAsync(getConfig(region)).getSecret(secretName, DBSecretModel.class).block();
    }

    private AWSSecretsManagerConfig getConfig(String region) {
        return AWSSecretsManagerConfig.builder()
                .region(Region.of(region))
                .cacheSize(5)
                .cacheSeconds(3600)
                .build();
    }

    private DBSecretModel dbSecretModelLocal(){
        return new DBSecretModel(this.password, this.dbname, this.port, this.host, this.username);
    }

}
