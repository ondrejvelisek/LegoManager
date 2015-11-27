package cz.muni.fi.pa165.lego.dto;

import cz.muni.fi.pa165.legomanager.entities.Model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.*;

/**
 * Data transfer object for {@link Model class}
 *
 * @author Ondrej Velisek <ondrejvelisek@gmail.com>
 */
public class ModelDTO {

    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    private CategoryDTO category = new CategoryDTO();

    @NotNull
    @Min(0)
    @Max(100)
    private Byte ageLimit;

    @NotNull
    @Min(0)
    private BigDecimal price;

    @NotNull
    private Set<PieceDTO> pieces = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Byte getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Byte ageLimit) {
        this.ageLimit = ageLimit;
    }

    public Set<PieceDTO> getPieces() {
        return pieces;
    }

    public void setPieces(Set<PieceDTO> pieces) {
        this.pieces = pieces;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ModelDTO)) {
            return false;
        }
        final ModelDTO other = (ModelDTO) obj;
        if (this.getId() == null) {
            return false;
        }
        if (!Objects.equals(this.getId(), other.getId())) {
            return false;
        }
        return true;

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ModelDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", ageLimit=" + ageLimit +
                ", price=" + price +
                ", pieces=" + pieces +
                '}';
    }
}
