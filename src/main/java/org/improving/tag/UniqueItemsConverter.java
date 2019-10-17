package org.improving.tag;

import org.improving.tag.items.UniqueItems;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter(autoApply = true)
public class UniqueItemsConverter implements AttributeConverter<UniqueItems, String> {

    @Override
    public String convertToDatabaseColumn(UniqueItems item) {
        return item.getName();
    }

    @Override
    public UniqueItems convertToEntityAttribute(String string) {
        return (Arrays
                .stream(UniqueItems.values())
                .filter(item -> item.getName().equals(string))
                .findFirst().orElse(null));
    }
}

