package willydekeyser.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Stream;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

public class CustomJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken>{

	private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
	
	private Collection<? extends GrantedAuthority> extractResourceRoles(final Jwt jwt) {
		Collection<GrantedAuthority> authorities = new HashSet<>();
		authorities.addAll(jwt.getClaimAsStringList("roles")
				.stream()
				.map(SimpleGrantedAuthority::new)
				.toList());
		return authorities;
	}
	
	@Override
	public AbstractAuthenticationToken convert(Jwt source) {
		
		Collection<GrantedAuthority> authorities = Stream
				.concat(jwtGrantedAuthoritiesConverter
				.convert(source)
				.stream(), extractResourceRoles(source)
							.stream())
				.toList();
		return new JwtAuthenticationToken(source, authorities);
	}

}
