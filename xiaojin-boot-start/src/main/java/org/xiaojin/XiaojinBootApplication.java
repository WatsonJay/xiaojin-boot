package org.xiaojin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.xiaojin.util.DataConvertUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
@Slf4j
@SpringBootApplication
public class XiaojinBootApplication {

	public static void main(String[] args) throws UnknownHostException {
		ConfigurableApplicationContext application = SpringApplication.run(XiaojinBootApplication.class, args);
		Environment env = application.getEnvironment();
		String ip = InetAddress.getLocalHost().getHostAddress();
		String port = env.getProperty("server.port");
		String path = DataConvertUtils.getString(env.getProperty("server.servlet.context-path"));
		log.info("\n----------------------------------------------------------\n\t" +
				"Application Xiaojin-Boot is started! Access URLs:\n\t" +
				"Local: \t\thttp://localhost:" + port + path + "/\n\t" +
				"External: \thttp://" + ip + ":" + port + path + "/\n\t" +
				"Swagger文档: \thttp://" + ip + ":" + port + path + "/doc.html\n" +
				"----------------------------------------------------------");

	}
}
