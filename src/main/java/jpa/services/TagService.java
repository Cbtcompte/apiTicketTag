package jpa.services;

import jpa.dtos.TagDto;
import jpa.models.Tag;
import jpa.repositories.TagRepository;

import java.util.ArrayList;
import java.util.List;

public class TagService {
    private TagRepository tagRepository;
    private TagDto tagDto;

    public TagService() {
        tagRepository = new TagRepository();
        tagDto = new TagDto();
    }

    /**
     * This method return all tag from database
     *
     * @return List<TagDto>
     */
    public List<TagDto> getAllTag(){
        tagRepository.getManager();
        List<Tag> t = tagRepository.selectAll();
        tagRepository.closeManager();
        List<TagDto> tagDtos = new ArrayList<>();
        if(!t.isEmpty()){
            for (Tag tag : t) {
                tagDtos.add(tagDto.fromEntity(tag));
            }
        }
        return tagDtos;
    }

    /**
     * This method return one tag from database. This tag is identify by its id
     *
     * @return TagDto
     */
    public TagDto getTag(Long id){
        tagRepository.getManager();
        Tag t = tagRepository.findById(id);
        tagRepository.closeManager();
        if(t != null){
            return tagDto.fromEntity(t);
        }

        return tagDto;
    }

    /**
     * This method is used to add new tag data in database
     * @param tD is TagDto
     * @return TagDto
     */
    public TagDto addTag(TagDto tD){
        Tag t = tD.toEntity();
        tagRepository.getManager();
        tagRepository.create(t);
        t = tagRepository.findById(t.getId());
        if(t != null){
            return tagDto.fromEntity(t);
        }
        return tagDto;
    }

    public void deleteTag(Long id){
        tagRepository.getManager();
        tagRepository.delete(id);

    }
    }
