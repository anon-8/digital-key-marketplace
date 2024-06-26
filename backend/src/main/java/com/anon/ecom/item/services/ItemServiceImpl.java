package com.anon.ecom.item.services;

import com.anon.ecom.item.ItemRepository;
import com.anon.ecom.item.domain.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    @Override
    public ItemEntity save(ItemEntity itemEntity) {
        return itemRepository.save(itemEntity);
    }
    @Override
    public ItemEntity createUpdateItem(Long id, ItemEntity item) {
        item.setId(id);
        return itemRepository.save(item);
    }
    @Override
    public List<ItemEntity> findAll() {
        return new ArrayList<>(itemRepository.findAll());
    }

    @Override
    public Page<ItemEntity> findAll(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }

    @Override
    public Optional<ItemEntity> findOne(Long id) {
        return itemRepository.findById(id);
    }
    @Override
    public boolean isExists(Long id) {
        return itemRepository.existsById(id);
    }
    @Override
    public ItemEntity partialUpdate(Long id, ItemEntity itemEntity) {
        itemEntity.setId(id);
        return itemRepository.findById(id).map(existingItem -> {

            Optional.ofNullable(itemEntity.getTitle()).ifPresent(existingItem::setTitle);

            return itemRepository.save(existingItem);
        }).orElseThrow(() -> new RuntimeException("Item does not exist"));
    }
    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
