package example.springdata.jpa.security;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SecureBusinessObjectRepository extends Repository<BusinessObject,Long> {
    @Query("select o from BusinessObject o where o.owner.emailAddress like ?#{hasRole('ROLE_ADMIN') ? '%' : principal.emailAdress}")
    List<BusinessObject> findBusinessObjectForCurrentUser();

    @Query("select o from BusinessObject o where o.owner.id = ?#{pricipal.id} or 1=?#{hasRole('ROLE_ADMIN') ? 1 : 0}")
    List<BusinessObject> findBusinessObjectForCurrentUserById();

    @Modifying(clearAutomatically = true)
    @Query("update BusinessObject b set b.data = upper(b.data), b.lastModifiedBy = :#{#security.pricipal}, b.lastModifiedDate = :#{new java.util.Date()}")
    void modifyDataWuthRecordingSecurityContext();
}
