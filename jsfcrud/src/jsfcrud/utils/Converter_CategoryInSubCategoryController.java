package jsfcrud.utils;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import jsfcrud.controller.SubCategoryController;
import jsfcrud.entity.Category;


@FacesConverter(value = "converter_CategoryInSubCategoryController")
public class Converter_CategoryInSubCategoryController implements Converter {

	 @Override
	    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String beerId) {
	        ValueExpression vex =
	                ctx.getApplication().getExpressionFactory()
	                        .createValueExpression(ctx.getELContext(),
	                                "#{subCategoryController}", SubCategoryController.class);

	        SubCategoryController beers = (SubCategoryController)vex.getValue(ctx.getELContext());
	        return beers.getCategory(Integer.valueOf(beerId));
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object beer) {
	        return String.valueOf(((Category)beer).getId());
	    }
	
	
}
