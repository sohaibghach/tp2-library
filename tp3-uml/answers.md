# TP 3 – Answers

## (a) `left to right direction` and the arrow
`left to right direction` changes the layout: actors are placed on the left and use cases on the right, instead of the default top-to-bottom layout.
In UML, the arrow in `Customer --> Withdraw` means navigability, not "who starts the use case".
Chapter 3 (Section 3.3.2) draws associations without arrowheads, and names the primary actor in the textual description.

## (b) Reversed extend relationship
No, the tool did not detect the reversed relationship: the diagram was rendered without any error.
A modeling tool checks the syntax (and, in some tools, the well-formedness of the model).
It does not check the meaning: the direction of include/extend, the level of the use cases, or whether the model is complete and consistent with the requirements. This is the analyst's responsibility (see Table 3.2: extend goes from the extending to the base use case).

## (c) Automatic layout of PlantUML
Advantages:
1. No time spent placing elements; the layout is updated automatically after each change.
2. The result is reproducible: the same text always gives the same diagram.

Drawbacks:
1. Limited control: lines cross and elements are not where we want them, even with direction hints.
2. A small change in the text can change the whole diagram.

## (d) PlantUML vs a graphical tool (Modelio)
| Criterion | PlantUML (text) | Modelio (graphical) |
|---|---|---|
| Editing | Typing text; fast for those who know the syntax | Drag and drop with a palette; easier for beginners |
| Layout | Automatic, little control | Manual, full control |
| Version control | Excellent: readable diff and merge | Difficult: XML/binary files, hard to compare |
| Consistency between diagrams | Weak: each file is independent | Strong: one shared model, a rename is propagated |

## (e) Models in the same repository as the code
- Models and code evolve together: one commit can change both, so the documentation stays up to date.
- Full history: we know when and why the design changed, and we can go back to an earlier version.
- The whole team works on the same version, with review of changes.
- Models are not lost or duplicated in different folders or emails.
