-- Insert initial data for waste_categories
INSERT INTO waste_categories (id, name, description) VALUES
                                                         (1, 'Plastic', 'Non-biodegradable waste that can be recycled into new products.'),
                                                         (2, 'Glass', 'Recyclable waste that can be processed into new glass items.'),
                                                         (3, 'Organic', 'Biodegradable waste suitable for composting.');

-- Insert initial data for disposal_guidelines
INSERT INTO disposal_guidelines (id, instruction, waste_category_id) VALUES
                                                                         (1, 'Dispose of plastic bottles in the yellow recycling bin.', 1),
                                                                         (2, 'Rinse and recycle glass jars in the green bin.', 2),
                                                                         (3, 'Place organic waste in the compost bin.', 3);
