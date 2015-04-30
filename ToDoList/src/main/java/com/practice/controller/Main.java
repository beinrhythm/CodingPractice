package com.practice.controller;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.practice.controller.dao.Dao;
import com.practice.controller.dao.StuffDao;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

/**
 * Created by abhi.pandey on 9/21/14.
 */
public class Main extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		final ResourceConfig rc = new PackagesResourceConfig( "com.practice.controller.server" );

		return Guice.createInjector( new ServletModule() {
			@Override
			protected void configureServlets() {
				bind( new TypeLiteral<Dao<String>>() {
				} ).to( StuffDao.class );

				for ( Class<?> resource : rc.getClasses() ) {
					System.out.println( "Binding resource: " + resource.getName() );
					bind( resource );
				}

				serve( "/services/*" ).with( GuiceContainer.class );
			}
		} );
	}
}
