package print;

import com.itextpdf.html2pdf.attach.ProcessorContext;
import com.itextpdf.html2pdf.attach.impl.tags.DivTagWorker;
import com.itextpdf.layout.IPropertyContainer;
import com.itextpdf.layout.element.Div;
import com.itextpdf.styledxmlparser.node.IElementNode;

public class HeaderTagWorker extends DivTagWorker{
	private int i;
	
	public HeaderTagWorker(IElementNode element, ProcessorContext context, int i) {
		super(element, context);
		// TODO Auto-generated constructor stub
		this.i = i;
	}
	
	@Override
    public IPropertyContainer getElementResult() {
        Div div =(Div) super.getElementResult();
        div.getAccessibilityProperties().setRole("H"+i);
        return super.getElementResult();
    }

}
