package formation.sopra.bu.projetDoki.configuration;




import formation.sopra.bu.projetDoki.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/rest/praticien").hasRole("PRATICIEN").and().httpBasic().and().csrf().disable();
		http.authorizeRequests().antMatchers("/rest/patient").hasRole("PATIENT").and().httpBasic().and().csrf().disable();
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/rest/**").hasRole("ADMIN").and().httpBasic().and().csrf().disable();
		
	}
	
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
	}
	@ Bean 
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
