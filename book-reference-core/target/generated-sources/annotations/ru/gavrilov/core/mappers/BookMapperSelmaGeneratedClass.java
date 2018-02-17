// GENERATED BY S3LM4
package ru.gavrilov.core.mappers;


public final class BookMapperSelmaGeneratedClass
    implements BookMapper {

  @Override
  public final ru.gavrilov.core.books.dto.BookDTO asBookDTO(ru.gavrilov.core.books.model.Book inBook) {
    ru.gavrilov.core.books.dto.BookDTO out = null;
    if (inBook != null) {
      out = new ru.gavrilov.core.books.dto.BookDTO();
      out.setDescription(inBook.getDescription());
      out.setId(inBook.getId());
      out.setTitle(inBook.getTitle());
      out.setYearOfPublication(inBook.getYearOfPublication());
      if (inBook.getAuthor() != null) {
        out.setAuthorId(inBook.getAuthor().getId());
      }
      if (inBook.getUser() != null) {
        out.setUserId(inBook.getUser().getId());
      }
    }
    return out;
  }


  @Override
  public final ru.gavrilov.core.books.model.Book asBook(ru.gavrilov.core.books.dto.BookDTO inBookDTO) {
    ru.gavrilov.core.books.model.Book out = null;
    if (inBookDTO != null) {
      out = new ru.gavrilov.core.books.model.Book();
      out.setDescription(inBookDTO.getDescription());
      out.setId(inBookDTO.getId());
      out.setTitle(inBookDTO.getTitle());
      out.setYearOfPublication(inBookDTO.getYearOfPublication());
      if (inBookDTO.getAuthorId() != null) {
        if (out.getAuthor() == null) {
          out.setAuthor(new ru.gavrilov.core.authors.model.Author());
        }
        out.getAuthor().setId(inBookDTO.getAuthorId());
      }
      if (inBookDTO.getUserId() != null) {
        if (out.getUser() == null) {
          out.setUser(new ru.gavrilov.core.users.model.User());
        }
        out.getUser().setId(inBookDTO.getUserId());
      }
    }
    return out;
  }



  /**
   * This field is used for custom Mapping
   */
  private BookCustomMapper customMapperBookCustomMapper;

  /**
   * Custom Mapper setter for customMapperBookCustomMapper
   */
  public final void setCustomMapperBookCustomMapper(BookCustomMapper mapper) {
    this.customMapperBookCustomMapper = mapper;
  }


  /**
   * Single constructor
   */
  public BookMapperSelmaGeneratedClass() {
    this.customMapperBookCustomMapper = new ru.gavrilov.core.mappers.BookCustomMapper();
  }

}