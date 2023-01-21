package co.com.efalvare.dynamodb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;

import java.net.URI;

@Configuration
public class DynamoDBConfig {

    @Value("${aws.dynamodb.accessKey}")
    private String accessKeyID;

    @Value("${aws.dynamodb.secretAccessKey}")
    private String secretAccessKey;

    @Value("${aws.dynamodb.region}")
    private String region;

    @Bean
    @Profile({"dev-local"})
    public DynamoDbAsyncClient amazonDynamoDB(@Value("${aws.dynamodb.endpoint}") String endpoint/*, MetricPublisher publisher*/) {
        AwsBasicCredentials basicCredentials = AwsBasicCredentials
                .create( this.accessKeyID, this.secretAccessKey );
        return DynamoDbAsyncClient.builder()
                .credentialsProvider(StaticCredentialsProvider.create(basicCredentials))
                .region(Region.of(region))
                .endpointOverride(URI.create(endpoint))
                //.overrideConfiguration(o -> o.addMetricPublisher(publisher))
                .build();
    }

    @Bean
    @Profile({"dev", "cer", "pdn"})
    public DynamoDbAsyncClient amazonDynamoDBAsync(/*MetricPublisher publisher*/) {
        return DynamoDbAsyncClient.builder()
                //.overrideConfiguration(o -> o.addMetricPublisher(publisher))
                .build();
    }

    @Bean
    public DynamoDbEnhancedAsyncClient getDynamoDbEnhancedAsyncClient(DynamoDbAsyncClient client) {
        return DynamoDbEnhancedAsyncClient.builder()
                .dynamoDbClient(client)
                .build();
    }

}
