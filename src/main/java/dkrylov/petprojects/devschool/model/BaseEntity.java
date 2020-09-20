package dkrylov.petprojects.devschool.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Base entity for all entities with optimistic locking that can be saved to database
 */
@Getter
@Setter
@MappedSuperclass
@EqualsAndHashCode(of = "id")
public class BaseEntity {
    public static final String PK_GENERATOR_NAME = "pk_generator";

    @Id
    @GeneratedValue(generator = PK_GENERATOR_NAME, strategy = GenerationType.SEQUENCE)
    private Long id;

    @Version
    private long version;
}
