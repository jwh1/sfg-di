package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.services.PrototypeBean;
import guru.springframework.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);



		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println("------- Primary Bean");
		System.out.println(myController.sayHello());

		System.out.println("------ Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("--------- Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("-------- Constructor" );
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		singletonBean1.setMyName("sbean1");
		System.out.println(singletonBean1.getMyScope());
		System.out.println("SingletonBean1.myName: " + singletonBean1.getMyName());
		SingletonBean singletonBean2 = ctx.getBean( SingletonBean.class);
		singletonBean2.setMyName("sbean2");
		System.out.println(singletonBean2.getMyScope());
		System.out.println("SingletonBean1.myName: " + singletonBean1.getMyName());
		System.out.println("SingletonBean2.myName: " + singletonBean2.getMyName());

		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		prototypeBean1.setMyName("pbean1");
		System.out.println(prototypeBean1.getMyScope());
		System.out.println("PrototypeBean1.myName: " + prototypeBean1.getMyName());
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		prototypeBean2.setMyName("pbean2");
		System.out.println(prototypeBean2.getMyScope());
		System.out.println("PrototypeBean1.myName: " + prototypeBean1.getMyName());
		System.out.println("PrototypeBean2.myName: " + prototypeBean2.getMyName());

		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println("FakeDataSource.username: " + fakeDataSource.getUsername());
		System.out.println("FakeDataSource.password: " + fakeDataSource.getPassword());
		System.out.println("FakeDataSource.jdbcurl: " + fakeDataSource.getJdbcurl());
	}

}
