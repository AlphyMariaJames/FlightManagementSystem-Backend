package com.flight.api.config;

public class WebSecurityConfig /* extends WebSecurityConfigurerAdapter */ {

	//@Autowired
	//UserDetailsServiceImpl userDetailsService;

	//@Autowired
	//private AuthEntryPointJwt unauthorizedHandler;

	/*
	 * @Bean public AuthTokenFilter authenticationJwtTokenFilter() { return new
	 * AuthTokenFilter();
	 * 
	 * }
	 * 
	 * @Override
	 * 
	 * public void configure(AuthenticationManagerBuilder
	 * authenticationManagerBuilder) throws Exception {
	 * 
	 * //authenticationManagerBuilder.userDetailsService(userDetailsService).
	 * passwordEncoder(passwordEncoder());
	 * 
	 * }
	 * 
	 * @Bean
	 * 
	 * @Override
	 * 
	 * public AuthenticationManager authenticationManagerBean() throws Exception {
	 * 
	 * return super.authenticationManagerBean();
	 * 
	 * }
	 * 
	 * @Bean
	 * 
	 * public PasswordEncoder passwordEncoder() {
	 * 
	 * return new BCryptPasswordEncoder();
	 * 
	 * }
	 * 
	 * @Override
	 * 
	 * protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http.cors().and().csrf().disable()
	 * 
	 * .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
	 * 
	 * .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
	 * and()
	 * 
	 * .authorizeRequests().antMatchers("/api/auth/**").permitAll()
	 * 
	 * .antMatchers("/api/test/**").permitAll()
	 * 
	 * .anyRequest().authenticated();
	 * 
	 * http.addFilterBefore(authenticationJwtTokenFilter(),
	 * UsernamePasswordAuthenticationFilter.class);
	 * 
	 * }
	 */
}
