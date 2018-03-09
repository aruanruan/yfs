package info.yangguo.yfs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author:杨果
 * @date:16/3/1 上午10:28
 * <p/>
 * Description:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/.*"))//此处配置需注意，需要暴露什么配置什么
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("YFS")
                .description("YFS REST API")
                .version("1.0")
                .termsOfServiceUrl("https://github.com/chengdedeng/yfs")
                .license("Apache License 2.0")
                .licenseUrl("https://en.wikipedia.org/wiki/Apache_License")
                .build();
    }
}
