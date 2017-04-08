package org.carlspring.strongbox.users.domain;

import org.carlspring.strongbox.data.domain.GenericEntity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.Objects;

/**
 * An application user
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User
        extends GenericEntity
{

    private String username;

    private String password;

    private boolean enabled;

    private String salt;

    private Set<String> roles;

    private String securityTokenKey;

    private Features features;

    public User()
    {
        roles = new HashSet<>();
    }

    public User(String id,
                String username,
                String password,
                boolean enabled,
                String salt,
                Set<String> roles)
    {
        this.objectId = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.salt = salt;
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return enabled == user.enabled &&
               Objects.equal(username, user.username) &&
               Objects.equal(password, user.password) &&
               Objects.equal(salt, user.salt) &&
               Objects.equal(roles, user.roles) &&
               Objects.equal(securityTokenKey, user.securityTokenKey) &&
               Objects.equal(features, user.features);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(username, password, enabled, salt, roles, securityTokenKey, features);
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(final String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(final String password)
    {
        this.password = password;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(final boolean enabled)
    {
        this.enabled = enabled;
    }

    public String getSalt()
    {
        return salt;
    }

    public void setSalt(final String salt)
    {
        this.salt = salt;
    }

    public Set<String> getRoles()
    {
        return roles;
    }

    public void setRoles(final Set<String> roles)
    {
        this.roles = roles;
    }

    public String getSecurityTokenKey()
    {
        return securityTokenKey;
    }

    public void setSecurityTokenKey(String securityTokenKey)
    {
        this.securityTokenKey = securityTokenKey;
    }

    public Features getFeatures()
    {
        return features;
    }

    public void setFeatures(Features features)
    {
        this.features = features;
    }


    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("username='")
          .append(username)
          .append('\'');
        sb.append(", password='")
          .append(password)
          .append('\'');
        sb.append(", enabled=")
          .append(enabled);
        sb.append(", salt='")
          .append(salt)
          .append('\'');
        sb.append(", roles=")
          .append(roles);
        sb.append(", securityTokenKey='")
          .append(securityTokenKey)
          .append('\'');
        sb.append(", features=")
          .append(features);
        sb.append('}');
        return sb.toString();
    }
}
