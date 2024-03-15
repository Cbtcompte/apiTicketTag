package jpa.services;

import jpa.dtos.TagDto;
import jpa.models.Tag;
import jpa.repositories.TagRepository;
import jpa.services.abstracts.Service;

import java.util.ArrayList;
import java.util.List;

public class TagService implements Service<TagDto>{
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
    @Override
    public List<TagDto> getAll(){
        List<Tag> t = tagRepository.selectAll();
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
    @Override
    public TagDto get(Long id){
        Tag t = tagRepository.findById(id);
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
    @Override
    public TagDto add(TagDto tD){
        Tag t = tD.toEntity();
        try {
            tagRepository.create(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        t = tagRepository.findById(t.getId());
        if(t != null){
            return tagDto.fromEntity(t);
        }
        return tagDto;
    }

    @Override
    public void delete(Long id){
        tagRepository.delete(id);
    }
}
