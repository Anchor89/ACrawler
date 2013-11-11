package anchor89.extractors;

import org.jsoup.nodes.Element;

public interface Extractor {
  String extract(Element element);
}
