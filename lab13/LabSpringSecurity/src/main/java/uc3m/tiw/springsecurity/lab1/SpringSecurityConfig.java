package uc3m.tiw.springsecurity.lab1;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	public enum UserRol {
		USER, ADMIN;
	}

	private final DataSource dataSource;

	private final String usersByUsernameQuery;

	private final String authoritiesByUsernameQuery;

	public SpringSecurityConfig(DataSource dataSource, @Value("${security-jdbc.user}") String usersByUsernameQuery, @Value("${security.jdbc-authorities}") String authoritiesByUsernameQuery) {

		this.dataSource = dataSource;
		this.usersByUsernameQuery = usersByUsernameQuery;
		this.authoritiesByUsernameQuery = authoritiesByUsernameQuery;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(usersByUsernameQuery)
				.authoritiesByUsernameQuery(authoritiesByUsernameQuery).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable()
				.authorizeRequests().antMatchers(HttpMethod.GET, "/country/**").authenticated()
				.antMatchers(HttpMethod.DELETE, "/country/**").hasRole(UserRol.ADMIN.name()).antMatchers("/**")
				.permitAll().and().httpBasic();
	}
}
