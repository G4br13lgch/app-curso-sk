package mx.smartkode.app.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import mx.smartkode.app.negocio.AppExcepcion;
import mx.smartkode.app.negocio.curso.dto.AutorDTO;
import mx.smartkode.app.negocio.curso.dto.CategoriaDTO;
import mx.smartkode.app.negocio.curso.dto.EditorialDTO;
import mx.smartkode.app.negocio.curso.dto.LibroDTO;
import mx.smartkode.app.negocio.curso.servicio.AutorServicio;
import mx.smartkode.app.negocio.curso.servicio.CategoriaServicio;
import mx.smartkode.app.negocio.curso.servicio.EditorialServicio;
import mx.smartkode.app.negocio.curso.servicio.LibroServicio;

@ManagedBean
@ViewScoped
public class LibroMBean implements Serializable {

	private static final long serialVersionUID = -259948820510443592L;
	private static Logger log = Logger.getLogger(LibroMBean.class);

	@ManagedProperty("#{libroServicio}")
	private LibroServicio libroServicio;
	@ManagedProperty("#{autorServicio}")
	private AutorServicio autorServicio;
	@ManagedProperty("#{editorialServicio}")
	private EditorialServicio editorialServicio;
	@ManagedProperty("#{categoriaServicio}")
	private CategoriaServicio categoriaServicio;

	private List<LibroDTO> libroDTOs;
	private List<AutorDTO> autorDTOs;
	private List<EditorialDTO> editorialDTOs;

	private LibroDTO libroDTO;
	private String filtroTitulo;
	private Map<String, Object> sessionMap;

	@PostConstruct
	public void inicio() {
		try {
			sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			libroDTO = new LibroDTO();
			setLibroDTOs(libroServicio.getAllLibros());
			setAutorDTOs(autorServicio.getAllAutores());
			setEditorialDTOs(editorialServicio.getAllEditoriales());
			setCategoriaDTOs(categoriaServicio.getAllCategorias());
		} catch (Exception e) {
			log.error("Error al obtener la lista de empleados: " + e);
		}
	}

	public void getAllLibrosByFiltroTitulo() {
		try {
			setLibroDTOs(libroServicio.getLibrosByFiltroTitulo(filtroTitulo));
		} catch (Exception e) {
			log.error("Error al consultar libros por filtro; " + e);
		}
	}

	public String addLibro() {
		try {
			libroServicio.addLibro(libroDTO);
		} catch (Exception e) {
			log.error("Error al agregar libro; " + e);
			return "nuevo-libro.xhtml?faces-redirect=true";
		}
		return "libros.xhtml?faces-redirect=true";
	}

	public String openViewUpdateLibro(LibroDTO libDTO) {
		sessionMap.put("libroDTO", libDTO);
		return "update-libro.xhtml?faces-redirect=true";
	}

	public String updateLibro(LibroDTO libroDTO) {
		try {
			libroServicio.updateLibro(libroDTO);
		} catch (Exception e) {
			log.error("Error al actualizar libro: " + e);
			return "update-libro.xhtml?faces-redirect=true";
		}
		return "libros.xhtml?faces-redirect=true";
	}

	public String deleteLibro(Integer idLibro) {
		try {
			libroServicio.deleteLibro(idLibro);
		} catch (Exception e) {
			log.error("Error al eliminar libro: " + e);
			return "libros.xhtml?faces-redirect=true";
		}
		return "libros.xhtml?faces-redirect=true";
	}

	public List<String> completeTextAutor(String query) {
		List<String> results = new ArrayList<>();
		for (AutorDTO autor : autorDTOs) {
			if (autor.getNombre().toLowerCase().contains(query.toLowerCase())) {
				results.add(autor.getNombre());
			}
		}
		return results;
	}

	public List<AutorDTO> completeTheme(String query) {
		String queryLowerCase = query.toLowerCase();
		List<AutorDTO> allThemes = null;
		try {
			allThemes = autorServicio.getAllAutores();
		} catch (AppExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allThemes.stream().filter(t -> t.getNombre().toLowerCase().startsWith(queryLowerCase))
				.collect(Collectors.toList());
	}

	public List<LibroDTO> getLibroDTOs() {
		return libroDTOs;
	}

	public EditorialServicio getEditorialServicio() {
		return editorialServicio;
	}

	public void setEditorialServicio(EditorialServicio editorialServicio) {
		this.editorialServicio = editorialServicio;
	}

	public CategoriaServicio getCategoriaServicio() {
		return categoriaServicio;
	}

	public void setCategoriaServicio(CategoriaServicio categoriaServicio) {
		this.categoriaServicio = categoriaServicio;
	}

	public void setLibroDTOs(List<LibroDTO> libroDTOs) {
		this.libroDTOs = libroDTOs;
	}

	public LibroServicio getLibroServicio() {
		return libroServicio;
	}

	public void setLibroServicio(LibroServicio libroServicio) {
		this.libroServicio = libroServicio;
	}

	public LibroDTO getLibroDTO() {
		return libroDTO;
	}

	public void setLibroDTO(LibroDTO libroDTO) {
		this.libroDTO = libroDTO;
	}

	public String getFiltroTitulo() {
		return filtroTitulo;
	}

	public void setFiltroTitulo(String filtroTitulo) {
		this.filtroTitulo = filtroTitulo;
	}

	public AutorServicio getAutorServicio() {
		return autorServicio;
	}

	public void setAutorServicio(AutorServicio autorServicio) {
		this.autorServicio = autorServicio;
	}

	public List<AutorDTO> getAutorDTOs() {
		return autorDTOs;
	}

	public void setAutorDTOs(List<AutorDTO> autorDTOs) {
		this.autorDTOs = autorDTOs;
	}

	public List<EditorialDTO> getEditorialDTOs() {
		return editorialDTOs;
	}

	public void setEditorialDTOs(List<EditorialDTO> editorialDTOs) {
		this.editorialDTOs = editorialDTOs;
	}

	public List<CategoriaDTO> getCategoriaDTOs() {
		return categoriaDTOs;
	}

	public void setCategoriaDTOs(List<CategoriaDTO> categoriaDTOs) {
		this.categoriaDTOs = categoriaDTOs;
	}

	private List<CategoriaDTO> categoriaDTOs;

}
