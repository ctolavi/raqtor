package dev.ctolavi.resources;

import dev.ctolavi.controllers.CategoryController;
import dev.ctolavi.entities.Category;
import dev.ctolavi.resources.dtos.CategoryDto;
import dev.ctolavi.resources.mapper.Mapper;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.modelmapper.TypeToken;

import java.util.List;
import java.util.Set;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class CategoryResource {

    private final CategoryController categoryController;

    private final Mapper mapper;

    public CategoryResource(CategoryController categoryController, Mapper mapper) {
        this.categoryController = categoryController;
        this.mapper = mapper;
    }

    @POST
    public Response createCategory(CategoryDto categoryDto) {
        Category category = mapper.map(categoryDto, Category.class);
        categoryController.save(category);
        return Response.status(Response.Status.CREATED).entity(mapper.map(category, CategoryDto.class)).build();
    }

    @GET
    public Response listClubs() {
        List<Category> categories = categoryController.getAll();
        return Response.ok(mapper.map(categories, new TypeToken<Set<CategoryDto>>() {
        }.getType())).build();
    }

}
